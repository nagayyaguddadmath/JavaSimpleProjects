package com.src.HackerNews.TopNews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;

public class HackerNewsRead {

	// http://localhost:8080/RESTfulExample/json/product/post
	public static void main(String[] args) {
		try {

			URL url = new URL("https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			Long[] topStories = null;// = new ArrayList<Long>();
			Gson gson = new Gson();
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				topStories = gson.fromJson(output, Long[].class);
				System.out.println(output);
			}
			
			String prefix = "https://hacker-news.firebaseio.com/v0/item/";
			String suffix = ".json?print=pretty";
//			for (int i = 0 ; i< topStories.length; i++) {
				URL urlStory = new URL(prefix + topStories[0] + suffix);
				HttpURLConnection connStory = (HttpURLConnection) urlStory.openConnection();

				BufferedReader brStory = new BufferedReader(new InputStreamReader(
						(connStory.getInputStream())));
				while ((output = brStory.readLine()) != null) {
//					topStories = gson.fromJson(output, Long[].class);
					System.out.println(output);
				}
				
				connStory.disconnect();
//			}
			
			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }

		}
		
		
		
/*	  try {

		URL url = new URL("https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

//		String input = "";

		OutputStream os = conn.getOutputStream();
//		os.write(input.getBytes());
		os.flush();

		if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
			throw new RuntimeException("Failed : HTTP error code : "
				+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	 }*/

//	}

}