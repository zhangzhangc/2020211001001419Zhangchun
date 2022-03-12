package com.zhangchun.dao;

import com.zhangchun.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {
        int n=0;
        String sql="delete from Product where ProductId=?";
        PreparedStatement pt=con.prepareStatement(sql);
        n=pt.executeUpdate();
        if(n>0){
            return n;
        }

        return 0;
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        Product bean = new Product();
        String sql="update Product set ProductName=?,ProductDescription=?,picture=?,price=?,CategoryId=? where ProductId=? ";
        PreparedStatement pt= con.prepareStatement(sql);
        pt.setString(1, bean.getProductName());
        pt.setString(2, bean.getProductDescription());
        pt.setString(3, String.valueOf(bean.getPicture()));
        pt.setString(4, String.valueOf(bean.getPrice()));
        pt.setString(5, String.valueOf(bean.getCategoryId()));
        pt.executeUpdate();


        return 0;
    }

    @Override
    public Product findById(Integer productId, Connection con) {
        return null;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) {
        return null;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {

        return null;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        return null;
    }
}
