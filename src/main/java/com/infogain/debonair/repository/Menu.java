package com.infogain.debonair.repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.infogain.debonair.dto.Items;

/**
 * Menu class is a repository which handles Menu operations
 * 
 * @author Chetna
 * @since 21-Apr-2020
 */
@Repository
public class Menu {
	/**
	 * This method is used to fetch menu from Items.txt file
	 * 
	 * @return
	 * @since 04-May-2020
	 */
	public List<Items> fetchMenu() {
		List<Items> ITEM_MENU = new ArrayList<>();
		try (BufferedReader bufferedReaderObj = new BufferedReader(new FileReader("./src/main/resources/Items.txt"))) {
			String itemTextObj;
			// reading each item line by line from bufferedReaderObject
			while ((itemTextObj = bufferedReaderObj.readLine()) != null) {
				String itemsArr[] = itemTextObj.split(",");
				int itemId = Integer.parseInt(itemsArr[0]);
				String itemName = itemsArr[1];
				float itemRate = Float.parseFloat(itemsArr[2]);
				double itemPrepTime = Double.parseDouble(itemsArr[3]);
				Items i = new Items(itemId, itemName, itemRate, itemPrepTime);
				ITEM_MENU.add(i);
			}
		} catch (FileNotFoundException fe) {
			System.err.println("Items.txt file was not found on the mentioned location");
		} catch (IOException e) {
			System.err.println(e + " while reading data from file on location: ./Items.txt");
		}
		return ITEM_MENU;
	}

}
