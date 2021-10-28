package ua.goit.homework.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.goit.homework.entity.BaseEntity;

@Service
@Slf4j
@RequiredArgsConstructor

public abstract class BaseService<E extends BaseEntity<ID>, ID>  {


}

