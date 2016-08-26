package com.speechanalysis.service;

/**
 * Created by pmusset on 6/15/16.
 */

import com.speechanalysis.model.Txt;

import java.util.List;

public interface TxtService {
    Iterable<Txt> listAllTxts();
}
