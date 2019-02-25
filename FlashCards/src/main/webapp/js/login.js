function check(form)
{
 if(form.userid.value == "employee1" || form.userid.value == "employee2" && form.pswrd.value == "123456")
  {
    window.open('mainmenu.html');
    form.reset();
  }
 else if(form.userid.value == "supervisor1" || form.userid.value == "supervisor2" && form.pswrd.value == "123456")
 {
	    window.open('mainmenuds.html');
	    form.reset();
	  }
 else if(form.userid.value == "head1" || form.userid.value == "head2" && form.pswrd.value == "123456")
 {
	    window.open('mainmenudh.html');
	    form.reset();
	  }
 else if(form.userid.value == "benco1" || form.userid.value == "benco2" && form.pswrd.value == "123456")
 {
	    window.open('mainmenudh.html');
	    form.reset();
	  }
 else
 {
   alert("Username or Password is invalid!")
  }
}