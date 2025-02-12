from selenium.webdriver.common.by import By
from pages.base_page import BasePage

class MenuPage(BasePage):
    MENU_BUTTON = (By.ID, "react-burger-menu-btn")
    LOGOUT_BUTTON = (By.ID, "logout_sidebar_link")

    def logout(self):
        self.click_element(self.MENU_BUTTON)
        self.click_element(self.LOGOUT_BUTTON)
