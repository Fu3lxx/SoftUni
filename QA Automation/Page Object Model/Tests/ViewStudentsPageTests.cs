using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using Students_Registry_Selenium_POM_Tests.pages;
using Students_Registry_Selenium_POM_Tests.Pages;

namespace Students_Registry_Selenium_POM_Tests.Tests
{
    public class ViewStudentsPageTests : BaseTest
    {
        [Test]
        public void Test_ViewStudentsPage_Content()
        {
            var page = new ViewStudentsPage(driver);
            page.Open();
            Assert.AreEqual("Students",page.GetPageTitle());
            Assert.AreEqual("Registered Students",page.getPageHeadingText());

            var students = page.GetRegisteredStudents();

            foreach (var st in students)
            {
                Assert.IsTrue(st.IndexOf("(") > 0);
                Assert.IsTrue(st.IndexOf(")") == st.Length-1);
            }
        }

        [Test]
        public void Test_ViewStudents_Links()
        {
            var page = new ViewStudentsPage(driver);

            page.Open();
            page.LinkHomePage.Click();
            Assert.IsTrue(new HomePage(driver).isOpen());

            page.Open();
            page.LinkViewStudentsPage.Click();
            Assert.IsTrue(new ViewStudentsPage(driver).isOpen());

            page.Open();
            page.LinkAddStudentsPage.Click();
            Assert.IsTrue(new AddStudentPage(driver).isOpen());
        }
    }
}
