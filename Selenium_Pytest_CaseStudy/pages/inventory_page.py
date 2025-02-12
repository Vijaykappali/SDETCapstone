from selenium.webdriver.common.by import By
from pages.base_page import BasePage

class InventoryPage(BasePage):
    ADD_TO_CART_BUTTON = (By.XPATH, "//button[contains(text(),'Add to cart')]")
    CART_ICON = (By.CLASS_NAME, "shopping_cart_link")

    def add_item_to_cart(self):
        self.click_element(self.ADD_TO_CART_BUTTON)

    def verify_item_added(self):
        return self.get_text(self.CART_ICON)
