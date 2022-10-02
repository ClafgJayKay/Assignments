
import Footer from "./Footer";
import Header from "./Header";

function Contact(){

    return(
        <>
            <Header menuname="Contact"/>
            <div id="body" class="contact">
                <div class="header">
                    <div>
                        <h1>Contact</h1>
                    </div>
                </div>
                <div class="body">
                    <div>
                        <div>/
                            <img src="images/check-in.png" alt=""/>
                            <h1>UNIT 0123 , ABC BUILDING, BUSSINESS PARK</h1>
                            <p>If you're having problems editing this website template, then don't hesitate to ask for help on the Forums.</p>
                        </div>
                    </div>
                </div>
                <div class="footer">
                    <div class="contact">
                        <h1>INQUIRY FORM</h1>
                        <form action="/Home">
                            <input type="text" placeholder="Name"  onBlur="this.value=!this.value?'Email':this.value;" onFocus="this.select()" onClick="this.value='';"/>
                            <input type="text" placeholder="Email"   onBlur="this.value=!this.value?'Email':this.value;" onFocus="this.select()" onClick="this.value='';"/>
                            <input type="text" placeholder="Subject"  onBlur="this.value=!this.value?'Subject':this.value;" onFocus="this.select()" onClick="this.value='';"/>
                            <textarea name="message" cols="50" rows="7">Share your thoughts</textarea>
                            <input type="submit" value="Send" id="submit"/>
                        </form>
                    </div>
                    <div class="section">
                        <h1>WE’D LOVE TO HEAR FROM YOU.</h1>
                        <p>If you're having problems editing this website template, then don't hesitate to ask for help on the Forums.</p>
                    </div>
                </div>
            </div>

            <Footer/>
        
        </>
    )
}
export default Contact;