package com.jujubebat.dao;

public class CategoryDaoSqls {

    public static final String SELECT_ALL =
                      "SELECT \n"
                    + "    category.id, category.NAME, COUNT(*) AS count\n"
                    + "FROM\n"
                    + "    product\n"
                    + "        INNER JOIN\n"
                    + "    category ON product.category_id = category.id\n"
                    + "GROUP BY category.id";
}
