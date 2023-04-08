    // Imports
// Librarys
import React from "react";
// Components
import { Nav } from "./Nav/Nav";

const links = [{
    "label": "Home",
    "route": "/"
}, {
    "label": "Vehicles",
    "route": "/vehicles"
}, {
    "label": "Messages",
    "route": "/messages"
}, {
    "label": "Clients",
    "route": "/clients"
}];

export function Header() {
    return(
        <React.Fragment>
            <header>
                <Nav links = {links} />
            </header>
        </React.Fragment>
    );
}