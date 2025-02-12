from selenium.webdriver.common.by import By
from pages.base_page import BasePage

class LoginPage(BasePage):
    USERNAME_INPUT = (By.ID, "user-name")
    PASSWORD_INPUT = (By.ID, "password")
    LOGIN_BUTTON = (By.ID, "login-button")
    SWAG_LABS_LABEL = (By.CLASS_NAME, "app_logo")

    def login(self, username, password):
        self.find_element(self.USERNAME_INPUT).send_keys(username)
        self.find_element(self.PASSWORD_INPUT).send_keys(password)
        self.click_element(self.LOGIN_BUTTON)

    def verify_swag_labs_present(self):
        return self.get_text(self.SWAG_LABS_LABEL)
