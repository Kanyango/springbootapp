package com.lengolyte.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lengolyte.domain.ChartInfo;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import java.util.Map;
//import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Encoders;
import org.apache.spark.api.java.function.ForeachFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Row;

import com.lengolyte.service.RowService;
import com.lengolyte.service.impl.RowServiceImpl;

//import org.codehaus.jackson.JsonGenerationException;
//import org.codehaus.jackson.map.JsonMappingException;
//import org.codehaus.jackson.map.ObjectMapper;
//import org.json.JSONArray;

@Controller
public class LengoController  {
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 726345043981910874L;

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RowServiceImpl rowServiceImpl;
	
	@RequestMapping("/home")
	public String rtnd(Model model)
	{
//		
//		Dataset<Row> rtnd_data = rowServiceImpl.countRows();
//		HashMap<String, ArrayList<Object>> To_json = new HashMap<String, ArrayList<Object>>();
	
		//HashMap<String, Object> x_axis = new HashMap<String, Object>();
		//ArrayList<Object> x_axis_vals = new ArrayList<Object>();
		//HashMap<String, ArrayList> y_axis = new HashMap<String, ArrayList>();
		//ArrayList<Object> y_axis_vals = new ArrayList<Object>();
		//HashMap<String, ArrayList> series = new HashMap<String, ArrayList>();
		//ArrayList<Object> series_vals = new ArrayList<Object>();
		
//		rtnd_data.foreach(new ForeachFunction<Row>()
//		{
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = 1L;
//			 
//			@Override
//			public void call(Row row) throws Exception
//			{
//				x_axis_vals.add(row.get(0));
//				y_axis_vals.add(row.get(2));
//				series_vals.add(row.get(1));
//			}
//				
//						
//		});
//		
//		To_json.put("x_axis", x_axis_vals);
//		To_json.put("y_axis", y_axis_vals);
//		To_json.put("series", series_vals);
//		
//		
//		System.out.println(To_json);
		
//		x_axis.put("x_axis", x_axis_vals);
//		y_axis.put("y_axis", y_axis_vals);
//		series.put("series", series_vals);
		
		
		
//		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
//		String jsonString = gson.toJson(To_json);
//		model.addAttribute("jsonde_df", jsonString);
//		System.out.println(jsonString);
		
		
		Dataset<String> new_count = rowServiceImpl.countRows().toJSON();
		List<String> jsonde_df = new_count.collectAsList();
		jsonde_df.toArray();
		System.out.println(jsonde_df.toArray());
		//System.out.println(new_count.toJSON());
		model.addAttribute("jsonde_df", jsonde_df);
		return "home";
		
		 //return Dataset<Row>(chartCreator.groupby(), HttpStatus.OK);
	} 

}
