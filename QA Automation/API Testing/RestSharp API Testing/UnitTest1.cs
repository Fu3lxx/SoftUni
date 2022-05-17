using System;
using System.Collections.Generic;
using System.Net;
using System.Threading.Tasks;
using Newtonsoft.Json;
using NUnit.Framework;
using RestSharp;
using RestSharp.Authenticators;
using RestSharp_Project;
using JsonSerializer = System.Text.Json.JsonSerializer;

namespace RestSarp_Project
{
    public class Tests
    {
        private RestClient client;
        [SetUp]
        public void Setup()
        {
            client = new RestClient("https://api.github.com/");
            client.Authenticator = new HttpBasicAuthenticator("fu3lxx", "put your token here");
        }

        [Test]
        public async Task Test_GitHub_APIRequest_IssuesStatusCode()
        {
            var request = new RestRequest("/repos/Fu3lxx/QA-Automation-Group-Review/issues");
            var response = await client.ExecuteAsync(request);

            Assert.AreEqual(HttpStatusCode.OK, response.StatusCode);
        }

        [Test]
        public async Task Test_GitHub_APIRequest_GetAllIssues()
        {
            var request = new RestRequest("/repos/Fu3lxx/QA-Automation-Group-Review/issues");
            var response = await client.ExecuteAsync(request);
            var issues = JsonSerializer.Deserialize<List<Issue>>(response.Content);

            Assert.That(issues.Count > 1);
        }

        [Test]
        public async Task Test_GitHub_APIRequest_GetIssueByNumber()
        {
            var request = new RestRequest("/repos/Fu3lxx/QA-Automation-Group-Review/issues/4");
            var response = await client.ExecuteAsync(request, Method.Get);

            var issues = JsonSerializer.Deserialize<Issue>(response.Content);
            Assert.AreEqual(HttpStatusCode.OK,response.StatusCode);
            Assert.AreEqual(issues.number,4);

        }

        [Test]
        public async Task Test_GitHub_APIRequest_GetInvalidIssueNumber()
        {
            var request = new RestRequest("/repos/Fu3lxx/QA-Automation-Group-Review/issues/123");
            var response = await client.ExecuteAsync(request, Method.Get);

            
            Assert.AreEqual(HttpStatusCode.NotFound, response.StatusCode);
        }

        [Test]
        public async Task Test_GitHub_APIRequest_CreateNewIssue()
        {
            var request = new RestRequest("/repos/Fu3lxx/QA-Automation-Group-Review/issues");
            string body = "issue body";
            string title = "issue from restsharp";
            request.AddBody(new {body,title});
            var response = await client.ExecuteAsync(request, Method.Post);
            var issue = JsonSerializer.Deserialize<Issue>(response.Content);


            Assert.Greater(issue.id,0);
        }

        [Test]
        public async Task Test_GitHub_APIRequest_UpdateExistingIssue()
        {
            var request = new RestRequest("/repos/Fu3lxx/QA-Automation-Group-Review/issues/4");
            string body = "Updated body";
            string title = "Update issue from restsharp";
            request.AddBody(new { body, title });
            var response = await client.ExecuteAsync(request, Method.Patch);
            var issue = JsonSerializer.Deserialize<Issue>(response.Content);


            Assert.AreEqual(issue.body,body);
        }


    }
}