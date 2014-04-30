package com.example.pruebalibreria;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;

public class MySpreadSheetIntegration {

	/**
	 * @param args
	 */
	public MySpreadSheetIntegration() throws AuthenticationException,
			MalformedURLException, IOException, ServiceException {
		// TODO Auto-generated method stub

	}

	public List<SpreadsheetEntry> conexionGSS() throws IOException,
			ServiceException {

		String USERNAME = "erppepe@gmail.com";
		String PASSWORD = "pepeerppepe";

		SpreadsheetService service = new SpreadsheetService(
				"MySpreadsheetIntegration");
		service.setProtocolVersion(SpreadsheetService.Versions.V3);

		service.setUserCredentials(USERNAME, PASSWORD);
		// Define the URL to request. This should never change.
		URL SPREADSHEET_FEED_URL = null;

		SPREADSHEET_FEED_URL = new URL(
				"https://spreadsheets.google.com/feeds/spreadsheets/private/full");

		// Make a request to the API and get all spreadsheets.
		SpreadsheetFeed feed = null;
		feed = service.getFeed(SPREADSHEET_FEED_URL, SpreadsheetFeed.class);

		List<SpreadsheetEntry> spreadsheets = feed.getEntries();
		return spreadsheets;
	}

}
