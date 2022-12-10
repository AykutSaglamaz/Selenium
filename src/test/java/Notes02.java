public class Notes02 {
    /*
   7. xpath
**  there are 2 type so to xpath
1. Absolute
2. Relative
Note : We should not use absolute for locating elements
***Locate the elements using relative xpath
<input type="email" class="form-control" placeholder="Email" data-test="email" name="session[email]" id="session_email">
//tag[@ANYattribute = 'Value of that attrubute'];
Tag : input
Attribute : type, class,placeholder......
Value : email, form-control,.....
XPATH FOR THIS ELEMENT : USE ANY OF THEM
//input[@type='email'];
//input[@class='form-control'];
//input[@placeholder='Email'];
//input[@data-test='email'];
//input[@name='session[email]'];
//input[@id='session_email'];

When xpath returns multiple elements, we can use index to go to get unique element
For example,  //input[@class='form-control'] return username and password elements

(//input[@class='form-control'])[1] --->> returns the username there is in the first index
(//input[@class='form-control'])[2] --->> returns the password there is in the second index

NOTE : If there are multiple match, findElement will give the first element by default.

     */
}
