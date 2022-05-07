
using System;
using NUnit.Framework;


namespace Collections.Test
{
    public class Tests
    {
        [SetUp]
        public void Setup()
        {

        }
        [Test]
        public void Test_Collection_Add()
        {
            Collection<int> nums = new Collection<int>();

            nums.Add(1);
            string actual = nums.ToString();


            Assert.AreEqual("[1]", actual);

        }
        [Test]
        public void Test_Collection_AddRangeWithGrow()
        {
            Collection<int> nums = new Collection<int>();

            nums.AddRange(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18);
            string actual = nums.ToString();


            Assert.AreEqual("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18]", actual);

        }
        [Test]
        public void Test_Collection_AddWithGrow()
        {
            Collection<int> nums = new Collection<int>(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 });

            
            string actual = nums.ToString();


            Assert.AreEqual("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18]", actual);

        }
        [Test]
        public void Test_Collection_Clear()
        {
            Collection<int> nums = new Collection<int>(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 });

            nums.Clear();
            string actual = nums.ToString();


            Assert.AreEqual("[]", actual);

        }

        [Test]
        public void Test_Collection_AddRange()
        {
            Collection<int> nums = new Collection<int>();

            nums.AddRange(1,2,3);
            string actual = nums.ToString();


            Assert.AreEqual("[1, 2, 3]", actual);

        }
        [Test]
        public void Test_Collection_ConstructorSingleItem()
        {
            Collection<int> nums = new Collection<int>((new int[] { 1 }));

            string actual = nums.ToString();

            Assert.AreEqual("[1]", actual);

        }
        [Test]
        public void Test_Collection_ConstructorMultipleItems()
        {
            Collection<int> nums = new Collection<int>((new int[] { 1, 2, 3 }));

            string actual = nums.ToString();

            Assert.AreEqual("[1, 2, 3]", actual);

        }
        [Test]
        public void Test_Collection_CountAndCapacity()
        {
            Collection<int> nums = new Collection<int>((new int[] { 1, 2, 3 }));

            int actualCapacity = nums.Capacity;
            int actualCount = nums.Count;


            Assert.AreEqual( 16, actualCapacity);
            Assert.AreEqual( 3, actualCount);

        }
        [Test]
        public void Test_Collection_InsertAtStart()
        {
            Collection<int> nums = new Collection<int>((new int[] { 1, 2, 3 }));

            nums.InsertAt(0, 0);
            string actual = nums.ToString();

            Assert.AreEqual("[0, 1, 2, 3]", actual);

        }
        [Test]
        public void Test_Collection_InsertAtMiddle()
        {
            Collection<int> nums = new Collection<int>((new int[] { 1, 2, 3 }));

            nums.InsertAt(1, 0);
            string actual = nums.ToString();

            Assert.AreEqual("[1, 0, 2, 3]", actual);

        }
        [Test]
        public void Test_Collection_InsertAtEnd()
        {
            Collection<int> nums = new Collection<int>((new int[] { 1, 2, 3 }));

            nums.InsertAt(2, 0);
            string actual = nums.ToString();

            Assert.AreEqual("[1, 2, 0, 3]", actual);

        }
        [Test]
        public void Test_Collection_InsertAtInvalidIndex()
        {
            Collection<int> nums = new Collection<int>((new int[] { 1, 2, 3 }));

            Assert.Throws<ArgumentOutOfRangeException>(() => nums.InsertAt(-1, 0));

        }


        [Test]
        public void Test_Collection_ToString_Single()
        {
            Collection<int> nums = new Collection<int>(new int[] { 1 });

            
            string actual = nums.ToString();


            Assert.AreEqual("[3]", actual);
            
        }

        [Test]
        public void Test_Collection_ToString_Multiple()
        {
            Collection<int> nums = new Collection<int>(new int[] {1, 2});

            
            string actual = nums.ToString();


            Assert.AreEqual("[1, 2]", actual);

        }
        [Test]
        public void Test_Collection_ToString_Empty()
        {
            Collection<int> nums = new Collection<int>();


            string actual = nums.ToString();


            Assert.AreEqual("[]", actual);

        }
        [Test]
        public void Test_Collection_CheckCapacity()
        {
            Collection<int> nums = new Collection<int>(new int[] { 1, 2, 3, 4, 5 });


            int actual = nums.Capacity;


            Assert.AreEqual(16, actual);

        }
        [Test]
        public void Test_Collection_ExchangeFirstLast()
        {
            Collection<int> nums = new Collection<int>((new int[] { 1, 2, 3 }));

            nums.Exchange(0 , 2);
            string actual = nums.ToString();

            Assert.AreEqual("[3, 2, 1]", actual);

        }
        [Test]
        public void Test_Collection_ExchangeMiddle()
        {
            Collection<int> nums = new Collection<int>((new int[] { 1, 2, 3 }));

            nums.Exchange(1, 1);
            string actual = nums.ToString();

            Assert.AreEqual("[1, 2, 3]", actual);

        }
        [Test]
        public void Test_Collection_ExchangeAtInvalidIndex()
        {
            Collection<int> nums = new Collection<int>((new int[] { 1, 2, 3 }));

            Assert.Throws<ArgumentOutOfRangeException>(() => nums.Exchange(-1, 0));

        }
        [Test]
        public void Test_Collection_GetByIndex()
        {
            Collection<int> nums = new Collection<int>((new int[] { 1, 2, 3 }));


            int actual = nums[0];

            Assert.AreEqual(1, actual);

        }
        [Test]
        public void Test_Collection_RemoveAtStart()
        {
            Collection<int> nums = new Collection<int>((new int[] { 1, 2, 3 }));


            nums.RemoveAt(0);
            String actual = nums.ToString();
           
            Assert.AreEqual("[2, 3]",actual);

        }
        [Test]
        public void Test_Collection_RemoveAtMiddle()
        {
            Collection<int> nums = new Collection<int>((new int[] { 1, 2, 3 }));


            nums.RemoveAt(1);
            String actual = nums.ToString();

            Assert.AreEqual("[1, 3]", actual);

        }
        [Test]
        public void Test_Collection_RemoveAtEnd()
        {
            Collection<int> nums = new Collection<int>((new int[] { 1, 2, 3 }));


            nums.RemoveAt(2);
            String actual = nums.ToString();

            Assert.AreEqual("[1, 2]", actual);

        }
        [Test]
        public void Test_Collection_RemoveAll()
        {
            Collection<int> nums = new Collection<int>((new int[] { 1, 2, 3 }));


            nums.RemoveAt(0);
            nums.RemoveAt(0);
            nums.RemoveAt(0);

            String actual = nums.ToString();

            Assert.AreEqual("[]", actual);

        }


    }

}