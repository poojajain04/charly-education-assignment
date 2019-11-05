package resources;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class TabHelper {

	public void SwitchToNewTab(WebDriver driver) {
		Set<String> tab_handles = driver.getWindowHandles();
		int number_of_tabs = tab_handles.size();
		int new_tab_index = number_of_tabs - 1;
		driver.switchTo().window(tab_handles.toArray()[new_tab_index].toString());

	}
}
