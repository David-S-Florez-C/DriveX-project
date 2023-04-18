import React from "react";
import Link from "next/link";

const ClientCard = (props) => {
    return(
        <React.Fragment>
            <div>
                <picture>
                    <img src = "" alt = {`Image ${props.id}`} />
                </picture>
                <div>
                    <h5>{props.name}</h5>
                    <p>{props.email}</p>
                    <p>{props.age}</p>

                    <Link href={`/clients/${props.id}`}>More details</Link>
                </div>
            </div>
        </React.Fragment>
    );
};

export default ClientCard;