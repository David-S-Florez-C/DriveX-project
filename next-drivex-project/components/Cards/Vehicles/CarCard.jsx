import React from "react";
import Link from "next/link";

const CarCard = (props) => {
    return(
        <React.Fragment>
            <div>
                <picture>
                    <img src = "" alt = {`Image ${props.id}`} />
                </picture>
                <div>
                    <h5>{props.brand}</h5>
                    <p>{props.model}</p>
                    <p>{props.category_id}</p>

                    <Link href={`/cars/${props.id}`}>More details</Link>
                </div>
            </div>
        </React.Fragment>
    );
};

export default CarCard;