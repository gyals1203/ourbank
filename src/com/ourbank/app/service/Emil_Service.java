package com.ourbank.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ourbank.app.mapper.Email_Mapper;

@Component
public class Emil_Service {
@Autowired
private Email_Mapper boardMapper;
}
