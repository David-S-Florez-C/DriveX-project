import React from "react";
import Nav from "./Nav/Nav";

const links = [{
    label: "Home",
    route: "/"
}, {
    label: "Cars",
    route: "/cars"
}, {
    label: "Messages",
    route: "/messages"
}, {
    label: "Clients",
    route: "/clients"
}, {
    label: "About",
    route: "/about"
}, {
    label: "Contact",
    route: "/contact"
}];

const Header = () => {
    return(
        <React.Fragment>
            <header>
                <Nav links={links} />
            </header>
        </React.Fragment>
    );
};

export default Header;