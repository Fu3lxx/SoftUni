﻿using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using Students_Registry_Selenium_POM_Tests.pages;
using Students_Registry_Selenium_POM_Tests.Pages;

namespace Students_Registry_Selenium_POM_Tests.Tests
{
    public class HomePageTest : BaseTest
    {
        [Test]
        public void Test_HomePage_Content()
        {
            var page = new HomePage(driver);

            page.Open();

            Assert.AreEqual("MVC Example",page.GetPageTitle());
            Assert.AreEqual("Students Registry",page.getPageHeadingText());
            page.GetStudentCount();
        }

        [Test]
        public void Test_HomePage_Links()
        {
            var homePage = new HomePage(driver);

            homePage.Open();
            homePage.LinkHomePage.Click();
            Assert.IsTrue(new HomePage(driver).isOpen());

            homePage.Open();
            homePage.LinkAddStudentsPage.Click();
            Assert.IsTrue(new AddStudentPage(driver).isOpen());

            homePage.Open();
            homePage.LinkViewStudentsPage.Click();
            Assert.IsTrue(new ViewStudentsPage(driver).isOpen());

        }

    }

}
