package com.lengolyte.repository;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public interface RowDataRepository {
	
	public Dataset<Row> getAllRows();
	
}
