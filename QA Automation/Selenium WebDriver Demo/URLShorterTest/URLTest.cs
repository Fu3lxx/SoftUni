using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace URLShorterTest
{
    public class Tests
    {
        private WebDriver chomeDriver;
        private IWebElement home;
        private IWebElement shortUrls;
        private IWebElement addUrls;

        [SetUp]
        public void Setup()
        {
            chomeDriver = new ChromeDriver();
            chomeDriver.Url = ("https://shorturl.nakov.repl.co");
            chomeDriver.Manage().Window.Maximize();
            home = chomeDriver.FindElement(By.CssSelector("body > header > a:nth-child(1)"));
            shortUrls = chomeDriver.FindElement(By.CssSelector("body > header > a:nth-child(3)"));
            addUrls = chomeDriver.FindElement(By.CssSelector("body > header > a:nth-child(5)"));
        }

        [Test]
        public void Verify_HomePage()
        {
            IWebElement titleElement = chomeDriver.FindElement(by: By.CssSelector("body > main > h1"));
            Assert.AreEqual("URL Shortener",titleElement.Text);
        }

        [Test]
        public void Verify_UrlsPage()
        {
            chomeDriver.Navigate().GoToUrl("https://shorturl.nakov.repl.co/urls");
            IWebElement titleElement = chomeDriver.FindElement(by: By.CssSelector("html > body > main > h1"));
            var firstCell =
                chomeDriver.FindElement(By.CssSelector
                    ("body > main > table > tbody > tr:nth-child(1) > td:nth-child(1)"));
            var secondCell = chomeDriver.FindElement(By.CssSelector
                ("body > main > table > tbody > tr:nth-child(1) > td:nth-child(2)"));

            Assert.AreEqual("Short URLs",titleElement.Text);
            Assert.AreEqual("https://nakov.com",firstCell.Text);
            Assert.AreEqual("http://shorturl.nakov.repl.co/go/nak",secondCell.Text);
        }

        [Test]
        public void Verify_AddValidUrl()
        {
            var random = new Random();
            var randomCode = (random.Next(1, 10000000).ToString() + "TEST");
            var url = "https://softuni.bg/";
            addUrls.Click();
            var addressElement = chomeDriver.FindElement(by: By.CssSelector("#url"));
            var codeElement = chomeDriver.FindElement(by: By.CssSelector("#code"));
            var createElement =
                chomeDriver.FindElement(
                    by: By.CssSelector("body > main > form > table > tbody > tr:nth-child(3) > td > button"));

            addressElement.Click();
            addressElement.SendKeys(url);
            codeElement.Click();
            codeElement.SendKeys(randomCode);
            createElement.Click();
            
            IList<IWebElement> links = chomeDriver.FindElements(By.TagName("tr"));

            Assert.That(links.Last().FindElement(By.ClassName("shorturl")).Text.Contains(randomCode));
        }

        [Test]
        public void Verify_AddInvalidUrl()
        {
            addUrls.Click();
            var addressElement = chomeDriver.FindElement(by: By.CssSelector("input#url"));
            var codeElement = chomeDriver.FindElement(by: By.CssSelector("input#code"));

            addressElement.SendKeys("https://");
            var createUrlEl = chomeDriver.FindElement(by: By.CssSelector("body > main > form > table > tbody > tr:nth-child(3) > td > button"));
            createUrlEl.Click();
            IWebElement invalidUrlElement = chomeDriver.FindElement(By.CssSelector("body > div"));

            Assert.AreEqual("Invalid URL!",invalidUrlElement.Text);

        }


        [TearDown]
        public void TearDown()
        {
            chomeDriver.Quit();
        }
    }
}