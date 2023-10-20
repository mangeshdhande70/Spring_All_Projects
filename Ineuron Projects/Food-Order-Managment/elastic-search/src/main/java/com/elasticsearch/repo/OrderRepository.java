package com.elasticsearch.repo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.elasticsearch.model.Order;

public interface OrderRepository extends ElasticsearchRepository<Order, Long> {

}
