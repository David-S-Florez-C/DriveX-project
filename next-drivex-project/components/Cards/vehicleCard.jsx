    // Imports
// Librarys
import React from "react";
import Link from "next/link";

export function VehicleCard(props) {
    return(
        <React.Fragment>
            <div>
                <img src="" alt={`Carro #${props.id}`} />
                <div>
                    <h3>{props.brand}</h3>
                    <p>{props.model}</p>
                    <p>{props.category}</p>
                </div>
                <Link href = {`/vehicles/${props.id}`}>Details - Features</Link>
            </div>
        </React.Fragment>
    );
}