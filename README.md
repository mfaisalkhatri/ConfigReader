# ConfigReader
**A simple utility framework which can be used to read config.properties file easily.**

**Getting Started**

*This page includes all the information you need to get started including setup, usage, advantages, sample test.*

**What to do when you need help?**
* Discuss your queries by writing to me at: 
* Mail: mohammadfaisalkhatri@gmail.com 
* Twitter: @mfaisal_khatri 
* LinkedIn: Mohammad Faisal Khatri

* If you find any issue which is bottleneck for you, search the issue tracker to see if it is already raised.
* If not raised, then you can create a new issue with required details as mentioned in the issue template.

**What you do if you like the project?**
* Spread the word with your network.
* Star the project to make the project popular.
* Stay updated with the project progress by Watching it.

**How to use this Framework:**
01. Reading "Config.Properties" is made much simple and easy now. Check the sample code and tests below:

```
This is the config file extract: 
searchtext=Apple iphone 8
```

02. You can instantiate "PropertiesReader" class and get the values from the properties file in below defined way:
```
@Test
	public void Test() throws FileNotFoundException, IOException, Throwable {

		PropertiesReader prop = new PropertiesReader();
		String srch = prop.getKey("searchtext");
		
		System.out.println("Value of search text key is: " +srch);
		Assert.assertEquals(srch, "Apple iphone 8");

	}
```

**In the above case, Getter/Setter can also be created to get values from the properties file.**
**Exceptions have been handled while reading file or when file is not found, so you don't have to worry, if any thing goes wrong in tests.**
**Appropriate logs will be generated in project folder when exception is caught.**

