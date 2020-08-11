package com.naradacode.micronautexamplejdbc
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable
import io.cucumber.datatable.DataTable
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When


class FindOwnersByNameSteps {
	ResponseObject response;

	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("API is ready")
	def app_is_started() {
		println "app is started"
	}

	@When("I request find owner by name (.*)")
	def request_find_pet_by_name(String name) {
		response = WS.sendRequest(findTestObject('findOwnersByName', [('name') : name]))
	}

	@Then("get response code (\\d+)")
	def get_response_code(int responseCode) {
		WS.verifyResponseStatusCode(response, responseCode)
	}

	@And("The owner details as below:")
	def get_response_data(DataTable data) {
		List<Map<String, String>> expected_pet_details = data.asMaps(String.class, String.class);

		WS.verifyElementPropertyValue(response, 'name', expected_pet_details[0].owner_name)
		WS.verifyElementPropertyValue(response, 'age', expected_pet_details[0].owner_age)
	}
}