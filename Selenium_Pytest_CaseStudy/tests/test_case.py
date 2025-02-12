import pytest
from pages.login_page import LoginPage
from pages.inventory_page import InventoryPage
from pages.menu_page import MenuPage

USERNAME = "standard_user"
PASSWORD = "secret_sauce"

def test_swag_labs_present(driver):
    login_page = LoginPage(driver)
    login_page.open_url("https://www.saucedemo.com/")
    assert "Swag Labs" in login_page.verify_swag_labs_present()

def test_add_item_to_cart(driver):
    login_page = LoginPage(driver)
    inventory_page = InventoryPage(driver)

    login_page.open_url("https://www.saucedemo.com/")
    login_page.login(USERNAME, PASSWORD)
    inventory_page.add_item_to_cart()
    assert inventory_page.verify_item_added() == "1"

def test_logout(driver):
    login_page = LoginPage(driver)
    menu_page = MenuPage(driver)

    login_page.open_url("https://www.saucedemo.com/")
    login_page.login(USERNAME, PASSWORD)
    menu_page.logout()
