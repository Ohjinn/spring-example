package com.sparta.springcore.service;

import com.sparta.springcore.domain.product.Product;
import com.sparta.springcore.web.dto.ProductMypriceRequestDto;
import com.sparta.springcore.domain.product.ProductRepository;
import com.sparta.springcore.web.dto.ProductRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

//    @Transactional이건 왜 안붙이지
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @Transactional
    public Product createProducts(ProductRequestDto productRequestDto){
        Product product = new Product(productRequestDto);
        productRepository.save(product);
        return product;
    }

    @Transactional
    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto){
        Product product = productRepository.findById(id).orElseThrow(()-> new NullPointerException("해당 아이디가 존재하지 않습니다."));

        int myPrice = requestDto.getMyprice();

        product.updateMyPrice(myPrice);
        return product;
    }

}
