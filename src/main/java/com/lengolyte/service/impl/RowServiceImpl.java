package com.lengolyte.service.impl;

import com.lengolyte.service.RowService;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import com.lengolyte.repository.RowDataRepository;
import org.springframework.stereotype.Service;

@Service
public class RowServiceImpl implements RowService{
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = -8169733339826571719L;
	@Autowired
	private RowDataRepository rowDataRepository;
	
	@Override
	public Dataset<Row> countRows() 
	{
		Dataset<Row> rtndAll = rowDataRepository.getAllRows();
		Dataset<Row> grupSum = rtndAll.groupBy("Description","Country").sum("UnitPrice");
		grupSum.show();
		return grupSum; 
	}

}
