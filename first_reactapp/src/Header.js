import './App.css';
function Header(){

    return(
        <ul className='menu'>

            <li><a href="home">Home</a></li>
            <li><a href="about">About</a></li>
            <li><a href="contacts">Contacts</a></li>
            <li><a href="#">Logout</a></li>

        </ul>
    )
}

export default Header;