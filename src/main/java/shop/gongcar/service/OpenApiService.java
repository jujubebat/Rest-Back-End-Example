package shop.gongcar.service;

import java.io.IOException;
import java.util.*;

import shop.gongcar.model.Product;
import shop.gongcar.model.ProductDate;
import shop.gongcar.model.ProductDetail;
import shop.gongcar.model.ProductImage;
import shop.gongcar.repository.product.ProductRepository;
import shop.gongcar.repository.productDate.ProductDateRepository;
import shop.gongcar.repository.productDetail.ProductDetailRepository;
import shop.gongcar.repository.productImage.ProductImageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;

@Service
public class OpenApiService {

    private static final Logger logger = LoggerFactory.getLogger(OpenApiService.class);
    private static final String baseUri = "http://openapi.onbid.co.kr/openapi/services";
    private static final String serviceKey = "TkWnKo4m9%2Bg22VKIj4%2B8C6Y%2BGwnrqO6QbFL5gvsi97hijXief5DvTU5rwE79p9wmY%2BpZVwwfqWBPT%2Fs9e%2BxvVQ%3D%3D";
    private final ProductRepository productRepository;
    private final ProductDetailRepository productDetailRepository;
    private final ProductDateRepository productDateRepository;
    private final ProductImageRepository productImageRepository;

    //HashMap<Pair<Long, Long>, Object> m;
    int ProductfileNum = 0;
    int ProductDetailfileNum = 0;
    int ProductDatefileNum = 0;

    @Autowired
    public OpenApiService(ProductRepository productRepository,
                          ProductDetailRepository productDetailRepository,
                          ProductDateRepository productDateRepository,
                          ProductImageRepository productImageRepository) {
        this.productRepository = productRepository;
        this.productDetailRepository = productDetailRepository;
        this.productDateRepository = productDateRepository;
        this.productImageRepository = productImageRepository;
    }

    public void updateDB() throws IOException, SAXException, ParserConfigurationException, TransformerException {
        //List<HashMap<Pair<Long, Long>, Object>> productMapList = getProductList();
        /*
               A XML (이전 데이터)

               B XML (최신 데이터)

               최신데이터를 모두 해쉬 맵 M에 넣는다.

               이전 데이터 하나하나를 조회한다.

               M에서 조회되지 않는 A 데이터 = 삭제할 데이터 → 맵에서 삭제하고 → 삭제 리스트에 넣음 (지우면 안됨 옛날 달력 기록 사라짐.)

               M에서 조회되는 데이터

               - 조회되지만 다른 데이터 = 업데이트할 데이터 →  맵에서 삭제하고업데이트 리스트에 넣음
               - 조회되면서 같은 데이터 = 그냥 냅둘 데이터 -> 맵에서 삭제

               M에 남은 데이터 = 새롭게 추가된 데이터 → 새롭게 추가할 리스트에 넣음
                */
        //Java에서 폴더의 모든 파일을 읽는 방법?
        //https://www.it-swarm.dev/ko/java/java%EC%97%90%EC%84%9C-%ED%8F%B4%EB%8D%94%EC%9D%98-%EB%AA%A8%EB%93%A0-%ED%8C%8C%EC%9D%BC%EC%9D%84-%EC%9D%BD%EB%8A%94-%EB%B0%A9%EB%B2%95/968527708/
        /*
           public void listFilesForFolder(final File folder) {
               for (final File fileEntry : folder.listFiles()) {
                   if (fileEntry.isDirectory()) {
                       listFilesForFolder(fileEntry);
                   } else {
                       System.out.println(fileEntry.getName());
                   }
               }
           }

           final File folder = new File("/home/you/Desktop");
           listFilesForFolder(folder);*/

        // new 폴더에 있는 파일들

    }

    // tag값의 정보를 가져오는 메소드
    private static String getTagValue(String tag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        if (nValue == null)
            return null;
        return nValue.getNodeValue();
    }

    // 캠코 공매물건 목록조회
    // 최신 테이블 정보 리턴.
    public void /*List<HashMap<Pair<Long, Long>, Object>>*/ getProductList() throws ParserConfigurationException, IOException, SAXException, TransformerException {

        // List<HashMap<Pair<Long, Long>, Object>> productMapList = new ArrayList<>();

        //HashMap<Pair<Long, Long>, Object> kamcoProductInfo = new HashMap<>(); // 캠코 공매 물건
        //HashMap<Pair<Long, Long>, Object> kamcoProductDetailInfo = new HashMap<>();
        ; // 물건 상세 정보
        //HashMap<Pair<Long, Long>, Object> kamcoProductDateInfo = new HashMap<>();
        ; // 일정 상세 정보

        int pageNo = 0;
        int productFileNum = 0;

        String[] DPSL_MTD_CD = {"0001", "0002"};

        for (int i = 1; i >= 0; i--) {

            while (true) {
                pageNo++;
                ProductfileNum++;
                String callBackURL = "";

                if (i < 2) // 캠코 공매 물건(0 == 임대, 1 == 매각)
                    callBackURL = baseUri + "/KamcoPblsalThingInquireSvc/getKamcoPbctCltrList?serviceKey=" + serviceKey + "&PBCT_BEGN_DTM=20200701&PBCT_CLS_DTM=20201001" + "&numOfRows=100&pageNo=" + pageNo + "&DPSL_MTD_CD=" + DPSL_MTD_CD[i];
                else if (i == 2) // 이용 기관 물건
                    callBackURL = baseUri + "/UtlinsttPblsalThingInquireSvc/getPublicSaleObject?serviceKey=" + serviceKey + "&PBCT_BEGN_DTM=20200701&PBCT_CLS_DTM=20201001" + "&numOfRows=100&pageNo=" + pageNo;

                DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
                Document doc = dBuilder.parse(callBackURL);

                NodeList nList = doc.getElementsByTagName("item");

                // xml 파일 저장
                /*
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                Result output = new StreamResult(new File("/gongdal_data/new/product/product"+ProductfileNum+".xml"));
                Source input = new DOMSource(doc);
                transformer.transform(input, output);*/

                System.out.println("#######공매물건목록조회#######");
                System.out.println(callBackURL);

                if (nList.getLength() == 0) break;

                doc.getDocumentElement().normalize();

                for (int j = 0; j < nList.getLength(); j++) {

                    Node nNode = nList.item(j);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        System.out.println("뚜뚜");
                        if(getTagValue("ENDPC", eElement) == null) continue;
                        System.out.println(getTagValue("ENDPC", eElement));

                        Product product = new Product();  // [빌터 패턴으로 객체 생성해보기]
                        product.setPublicAuctionNum(Long.parseLong(getTagValue("PBCT_NO", eElement)));
                        product.setNoticeNum(Long.parseLong(getTagValue("PLNM_NO", eElement)));
                        product.setPublicAuctionConditionNum(Long.parseLong(getTagValue("PBCT_CDTN_NO", eElement)));
                        product.setObjectNum(Long.parseLong(getTagValue("CLTR_NO", eElement)));
                        product.setObjectRecordNum(Long.parseLong(getTagValue("CLTR_HSTR_NO", eElement)));
                        product.setScreenGroupCode(getTagValue("SCRN_GRP_CD", eElement));
                        product.setBidNum(getTagValue("BID_MNMT_NO", eElement));
                        product.setObjectName(getTagValue("CLTR_NM", eElement));
                        product.setUseName(getTagValue("CTGR_FULL_NM", eElement));
                        product.setObjectManagementNum(getTagValue("CLTR_MNMT_NO", eElement));
                        product.setLotNum(getTagValue("LDNM_ADRS", eElement));
                        product.setRoadName(getTagValue("NMRD_ADRS", eElement));
                        product.setDisposalMethodCode(getTagValue("DPSL_MTD_CD", eElement));
                        product.setDisposalMethodCodeName(getTagValue("DPSL_MTD_NM", eElement));
                        product.setBidMethod(getTagValue("BID_MTD_NM", eElement));
                        product.setMinimumBidPrice(getTagValue("MIN_BID_PRC", eElement));
                        product.setAppraisedPrice(Long.parseLong(getTagValue("APSL_ASES_AVG_AMT", eElement)));
                        product.setMinimumBidPriceRate(getTagValue("FEE_RATE", eElement));
                        product.setBidBeginDateTime(Long.parseLong(getTagValue("PBCT_BEGN_DTM", eElement)));
                        product.setBidCloseDateTime(Long.parseLong(getTagValue("PBCT_CLS_DTM", eElement)));
                        product.setObjectCondition(getTagValue("PBCT_CLTR_STAT_NM", eElement));
                        product.setFailBidCount(getTagValue("USCBD_CNT", eElement));
                        product.setOnbidViews(getTagValue("IQRY_CNT", eElement));
                        product.setProductDetailInfo(getTagValue("GOODS_NM", eElement));
                        product.setManufacturer(getTagValue("MANF", eElement));
                        product.setModel(getTagValue("MDL", eElement));
                        product.setYearAndMonth(Long.parseLong(getTagValue("NRGT", eElement)));
                        product.setTransmission(getTagValue("GRBX", eElement));
                        product.setDisplacement(Long.parseLong(getTagValue("ENDPC", eElement).replaceAll("[^0-9]","")));
                        product.setDistanceDriven(Long.parseLong(getTagValue("VHCL_MLGE", eElement).replaceAll("[^0-9]","")));
                        product.setFuelType(getTagValue("FUEL", eElement));
                        product.setCorporationName(getTagValue("SCRT_NM", eElement));
                        product.setBusinessType(getTagValue("TPBZ", eElement));
                        product.setEventName(getTagValue("ITM_NM", eElement));
                        product.setMembershipName(getTagValue("MMB_RGT_NM", eElement));

                       if(product.getFuelType() != null){
                            Product savedProduct = productRepository.save(product);

                            NodeList imgeList = eElement.getElementsByTagName("CLTR_IMG_FILES").item(0).getChildNodes();
                            Element e = (Element) imgeList;

                            for (int k = 0; k < e.getElementsByTagName("CLTR_IMG_FILE").getLength(); k++) {
                                System.out.println(e.getElementsByTagName("CLTR_IMG_FILE").item(k).getChildNodes().item(0).getNodeValue());
                                ProductImage productImage = new ProductImage();
                                productImage.setProduct(product);
                                productImage.setImgUrl(e.getElementsByTagName("CLTR_IMG_FILE").item(k).getChildNodes().item(0).getNodeValue());
                                productImageRepository.save(productImage);
                            }

                            System.out.println("##############################################");


                            String PLNM_NO = getTagValue("PLNM_NO", eElement);
                            String PBCT_NO = getTagValue("PBCT_NO", eElement);

                            // Pair key = new Pair<Long, Long>(Long.parseLong(PLNM_NO), Long.parseLong(PBCT_NO));

                            //kamcoProductInfo.put(key, product); // 물건 정보 map에 추가
                            getKamcoPlnmPbctBasicInfoDetail(product, PLNM_NO, PBCT_NO);
                            //kamcoProductDetailInfo.put(key, getKamcoPlnmPbctBasicInfoDetail(PLNM_NO, PBCT_NO)); // 상세정보 map에 추가

                            List<ProductDate> list = getKamcoPlnmPbctBidDateInfoDetail(savedProduct, PLNM_NO, PBCT_NO);
                            for (ProductDate productDate : list) {
                                // kamcoProductDateInfo.put(key, productDate); // 상세 일정 정보 map에 추가
                            }
                        }

                    }
                }
            }
        }

        //    productMapList.add(kamcoProductInfo);
        //   productMapList.add(kamcoProductDetailInfo);
        //  productMapList.add(kamcoProductDateInfo);

        //  return productMapList;
    }

    // 캠코공매공고 기본정보 상세조회
    public ProductDetail getKamcoPlnmPbctBasicInfoDetail(Product product, String PLNM_NO, String PBCT_NO) throws ParserConfigurationException, IOException, SAXException, TransformerException {

        String callBackURL = baseUri + "/KamcoPblsalThingInquireSvc/getKamcoPlnmPbctBasicInfoDetail?serviceKey=" + serviceKey + "&PLNM_NO=" + PLNM_NO + "&PBCT_NO=" + PBCT_NO;
        DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
        Document doc = dBuilder.parse(callBackURL);
        Node nNode = doc.getElementsByTagName("item").item(0);

        ProductDetailfileNum++;

        /*
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Result output = new StreamResult(new File("/gongdal_data/new/product_detail/productDetail"+ProductDetailfileNum+".xml"));
        Source input = new DOMSource(doc);
        transformer.transform(input, output);*/

        //System.out.println("    #######상세조회#######");
        //System.out.println("    " + callBackURL);

        if (nNode == null) return null;
        Element eElement = (Element) nNode;

        ProductDetail productDetail = new ProductDetail();

        productDetail.setNoticeNum(Long.parseLong(PLNM_NO));
        productDetail.setPublicAuctionNum(Long.parseLong(PBCT_NO));
        productDetail.setNoticeName(getTagValue("PLNM_NM", eElement));
        productDetail.setNoticeOrganization(getTagValue("ORG_NM", eElement));
        productDetail.setManagementDepartment(getTagValue("RSBY_DEPT", eElement));
        productDetail.setManagerName(getTagValue("PSCG_NM", eElement));
        productDetail.setManagerTel(getTagValue("PSCG_TPNO", eElement));
        productDetail.setManagerEmail(getTagValue("PSCG_EMAL_ADRS", eElement));
        productDetail.setNoticeType(getTagValue("PLNM_KIND_NM", eElement));
        productDetail.setNoticeDateTime(getTagValue("PLNM_DT", eElement));
        productDetail.setNoticeYear(getTagValue("PLNM_YR", eElement));
        productDetail.setNoticeSequence(getTagValue("PLNM_SEQ", eElement));
        productDetail.setPropertyDivision(getTagValue("PRPT_DVSN_NM", eElement));
        productDetail.setAssetDivision(getTagValue("AST_DVSN_NM", eElement));
        productDetail.setNoticeManagementName(getTagValue("PLNM_MNMT_NO", eElement));
        productDetail.setOrganizationNoticeNum(getTagValue("ORG_PLNM_NO", eElement));
        productDetail.setRelateNoticeNum(getTagValue("RLTN_PLNM_NO", eElement));
        productDetail.setRelateNoticeName(getTagValue("RLTN_PLNM_TITL", eElement));
        productDetail.setBidMethodType(getTagValue("BID_MTD_NM", eElement));
        productDetail.setDisposeType(getTagValue("DPSL_MTD_NM", eElement));
        productDetail.setCompetitionType(getTagValue("CPTN_MTD_NM", eElement));
        productDetail.setTotalAmountUnitPriceDivisionName(getTagValue("TOT_AMT_UNPC_DVSN_NM", eElement));
        productDetail.setEligibility(getTagValue("PTCT_QLFC", eElement));
        productDetail.setReBidFlag(getTagValue("RBD_YN", eElement));
        productDetail.setCommonBidFlag(getTagValue("COMN_BID_PMSN_YN", eElement));
        productDetail.setSubstituteBidFlag(getTagValue("SUBT_BID_PMSN_YN", eElement));
        productDetail.setNoticeDocument(getTagValue("PLNM_DOC", eElement));
        productDetail.setBidDateInfosTotalCount(getTagValue("bidDateInfosTotalCount", eElement));
        productDetail.setFilesTotalCount(getTagValue("filesTotalCount", eElement));

        productDetail.setProduct(product);

        productDetailRepository.save(productDetail);

        return productDetail;
    }

    // 캠코공매공고 공매일정 상세조회
    public List<ProductDate> getKamcoPlnmPbctBidDateInfoDetail(Product product, String PLNM_NO, String PBCT_NO) throws ParserConfigurationException, IOException, SAXException, TransformerException {

        List<ProductDate> productDateList = new ArrayList<>();

        int pageNo = 0;

        pageNo++;
        ProductDatefileNum++;

        String callBackURL = baseUri + "/KamcoPblsalThingInquireSvc/getKamcoPlnmPbctBidDateInfoDetail?serviceKey=" + serviceKey + "&PLNM_NO=" + PLNM_NO + "&PBCT_NO=" + PBCT_NO + "&pageNo=" + pageNo + "&numOfRows=100";

        //System.out.println("    #######날짜조회#######");
        //System.out.println("    " + callBackURL);

        DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
        Document doc = dBuilder.parse(callBackURL);

        /*
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Result output = new StreamResult(new File("/gongdal_data/new/product_date/productDate"+ProductDatefileNum+".xml"));
        Source input = new DOMSource(doc);
        transformer.transform(input, output);
*/
        NodeList nList = doc.getElementsByTagName("bidDateInfoItem");

        doc.getDocumentElement().normalize();

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                ProductDate productDate = new ProductDate();  // [빌터 패턴으로 객체 생성해보기]

                productDate.setProduct(product);
                productDate.setNoticeNum(Long.parseLong(PLNM_NO));
                productDate.setPublicAuctionNum(Long.parseLong(PBCT_NO));
                productDate.setPublicAuctionSequence(getTagValue("PBCT_SEQ", eElement));
                productDate.setPublicAuctionDegree(getTagValue("PBCT_DGR", eElement));
                productDate.setBidDivisionName(getTagValue("BID_DVSN_NM", eElement));
                productDate.setLessTwoPeopleFailBidFlag(getTagValue("TWPS_LSTH_USBD_YN", eElement));
                productDate.setMoreTwoSequenceBidFlag(getTagValue("TWTM_GTHR_BID_PSBL_YN", eElement));
                productDate.setElectronicWarrantyFlag(getTagValue("ELTR_GRT_DOC_USE_YN", eElement));
                productDate.setParticipationFee(Long.parseLong(getTagValue("PTCT_CMSN", eElement)));
                productDate.setBidDepositRate(Double.parseDouble(getTagValue("TDPS_RT", eElement)));
                productDate.setBidStartDateTime(getTagValue("PBCT_BEGN_DTM", eElement));
                productDate.setBidEndDateTime(getTagValue("PBCT_CLS_DTM", eElement));
                productDate.setBidOpenDateTime(getTagValue("PBCT_EXCT_DTM", eElement));
                productDate.setBidOpenPlace(getTagValue("OPBD_PLC_CNTN", eElement));

                productDateRepository.save(productDate);
                productDateList.add(productDate);
            }
        }
        return productDateList;
    }
}


