import React from "react";
import Link from "next/link";

const Nav = ({links}) => {
    return(
        <React.Fragment>
            <nav>
                <menu>
                    <ul>
                        {links.map(({label, route}) => (
                            <li key = {route}>
                                <Link href = {route}>{label}</Link>
                            </li>
                        ))}
                    </ul>
                </menu>
            </nav>
        </React.Fragment>
    );
}

export default Nav;