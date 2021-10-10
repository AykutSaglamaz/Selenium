public class Notes03 {
        /*
What do you remember from the last class
Locators : Used to find elements from the website
	Id, name, className, tagName, linkText, partialLinkText, xpath, ccsSelector
In which order, do you use locators ?
	Selen's answer : I use id first, because there should have UNIQUE id. If there is no id. then I use name-if is a unique name.
	class='btn-btnprimary' I usually don't use class because they are usually not UNIQUE. I don't use tags there are not generally unique.
	 If the element is a link, then I prefer to use linkText or partialLinkText. Actually there is xpath I also prefer to use for locations of elements.
	  I am good at writing dynamic xpath for the elements. I can write xpath for any element on the page.Even though xpath a little slower, it is safer to use,
findElement(By.Locator('value')) --> returns single element.(When multiple match, returns the first element).
                Returns WebElement, If there is no match then throws nosuchelemetexception
findElements(By.Locator('value'))--> returns multiple elements. Return type is
               List<WebElement>, if there is no match, returns empty List. Doesn't throw exception.
xpath : There are 2 xpath. absolute and relative
Absolute xpath : Navigation from the first parent to the targeted element 1 by 1. / is used.
Relative xpath : Navigating the elements using relative path. No need to go from parent to child 1 by 1. // is used

//tag[@attribute = 'value of that attribute']
There are multiple ways to write xpath.
Example website is : https://qa-environment.resortsline.com/
xpath using index.
//h2[.='Welcome To Our Hotel']
The combination can be used to locate the text on the page
//tagname[.='text name']
Dynamic elements are web elements which have identifiers that are dynamically generated during run time
     */
}
