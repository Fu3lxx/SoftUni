
using System;
using NuGet.Frameworks;
using NUnit.Framework;
using Students_Registry_Selenium_POM_Tests.pages;
using Students_Registry_Selenium_POM_Tests.Pages;

namespace Students_Registry_Selenium_POM_Tests.Tests
{
    public class AddStudentPageTests : BaseTest
    {
        [Test]
        public void Test_TestAddStudentsPage_Content()
        {
            var page = new AddStudentPage(driver);
            page.Open();

            Assert.AreEqual("Add Student", page.GetPageTitle());
            Assert.AreEqual("Register New Student",page.getPageHeadingText());
            Assert.AreEqual("Add",page.ButtonAdd.Text);
            Assert.AreEqual("",page.FieldStudentName.Text);
            Assert.AreEqual("",page.FieldStudentEmail.Text);
        }

        [Test]
        public void Test_TestAddStudentPage_Links()
        {
            var page = new AddStudentPage(driver);

            page.Open();
            page.LinkHomePage.Click();
            Assert.IsTrue( new HomePage(driver).isOpen());

            page.Open();
            page.LinkViewStudentsPage.Click();
            Assert.That( new ViewStudentsPage(driver).isOpen );

            page.Open();
            page.LinkAddStudentsPage.Click();
            Assert.That(new AddStudentPage(driver).isOpen);
        }

        [Test]
        public void Test_TestAddStudentsPage_AddValidStudent()
        {
            string studentName = "OlivieShampen" + DateTime.Now.Ticks;
            string studentEmail = "Shampen" + DateTime.Now.Ticks + "@gmail.com";
            var addStudentPage = new AddStudentPage(driver);
            addStudentPage.Open();

            addStudentPage.RegisterStudent(studentName,studentEmail);

            var viewStudentPage = new ViewStudentsPage(driver);
            viewStudentPage.Open();
            Assert.IsTrue(new ViewStudentsPage(driver).isOpen());

            var students = viewStudentPage.GetRegisteredStudents();
            Assert.AreEqual(studentName + " (" + studentEmail + ")",
                students[students.Length - 1] );

        }

        [Test]
        public void Test_TestAddStudentsPage_AddInvalidStudent()
        {
            var addStudentPage = new AddStudentPage(driver);
            addStudentPage.Open();

            addStudentPage.RegisterStudent("","student@gmail.com");
            Assert.IsTrue(new AddStudentPage(driver).isOpen());
            Assert.IsTrue(addStudentPage.ErrorMessage.Text.Contains("Cannot add student"));
            addStudentPage.GetErrorMessage();
        }

    }
}
