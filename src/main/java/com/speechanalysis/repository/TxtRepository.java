package com.speechanalysis.repository;

import com.speechanalysis.model.Txt;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by pmusset on 6/15/16.
 */

public interface TxtRepository extends PagingAndSortingRepository<Txt, Integer> {
}
