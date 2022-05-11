using System;
using System.Collections.Generic;
using System.Text.Json.Serialization;
using System.Threading.Tasks;
using Newtonsoft.Json;
using NUnit.Framework;
using RestSharp;
using RestSharp.Serializers.Json;

namespace DataDrivenTestingExercise
{
    public class Tests
    {
        [SetUp]
        public void Setup()
        {
        }

        [TestCase("BG", "1000", "Sofija")]
        [TestCase("BG", "8600", "Jambol")]
        [TestCase("CA", "M5S", "Toronto")]
        [TestCase("GB", "B1", "Birmingham")]
        [TestCase("DE", "01067", "Dresden")]
        public async Task TestZipopotamus(
            string countryCode, string zipCode, string expectedPlace)
        {

            var client = new RestClient("https://api.zippopotam.us");
            var request = new RestRequest(countryCode + "/" + zipCode);

            var response = await client.ExecuteAsync(request, Method.Get);
            var location = new SystemTextJsonSerializer().Deserialize<Location>(response);
            
            StringAssert.Contains(expectedPlace, location.Places[0].PlaceName);
        }

        public class Location
        {
            [JsonPropertyName("post code")]
            public string postCode { get; set; }

            [JsonPropertyName("country")]
            public string Country { get; set; }

            [JsonPropertyName("country abbreviation")]
            public string CountryAbbreviation { get; set; }

            [JsonPropertyName("places")]
            public List<Places> Places { get; set; }
        }

        public class Places
            {
                [JsonPropertyName("place name")]
                public string PlaceName { get; set; }
                public string State { get; set; }
                public string StateAbbreviation { get; set; }
                public string Latitude { get; set; }
                public string Longitude { get; set; }

            }
        }
    }
