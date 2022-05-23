

using System;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;
using SeleniumExtras.WaitHelpers;

namespace Selenium_Waits
{
    public class SeleniumWaits : BaseTest
    {
        [Test]
        public void Implicit()
        {
            driver.Navigate().GoToUrl("https://nakov.com/videos/");
            driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(20);
            
            driver.FindElement(By.CssSelector(".aligncenter.size-large > a[target='_blank'] > img")).Click();
            driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(20);
            Assert.IsTrue(true);
        }

        [Test]
        public void Explicit()
        {
            var wait = new WebDriverWait(driver, TimeSpan.FromSeconds(5));
            driver.Navigate().GoToUrl("https://nakov.com/videos/");
            var videoImage =
                wait.Until(e => e.FindElement(By.CssSelector("body > div.main-content > div.post-content > div.post-text > div:nth-child(2) > figure > a > img")));

            videoImage.Click();

            Assert.IsTrue(true);
        }

        [Test]
        public void Explicit_withCondition()
        {
            var wait = new WebDriverWait(driver, TimeSpan.FromSeconds(5));
            driver.Navigate().GoToUrl("https://nakov.comvideos/");
            var element = wait.Until(ExpectedConditions.ElementToBeClickable(By.CssSelector(
                "body > div.main-content > div.post-content > div.post-text > div:nth-child(2) > figure > a > img")));

            Assert.IsTrue(true);
        }
    }
}
