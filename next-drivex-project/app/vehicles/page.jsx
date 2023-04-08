    // Imports
// Librarys
import { VehicleCard } from "@/components/Cards/VehicleCard";
import React from "react";

var requestOptions = {
    method: 'GET',
    redirect: 'follow'
};
  
async function getData() {
    const res = await fetch('https://g4932924a17736e-ca5bxc3sr3p4rtcw.adb.us-chicago-1.oraclecloudapps.com/ords/admin/car/car', {cache: 'no-store'});
    return res.json();
}

export default async function AllVehicles() {

    let data = await getData();
    console.log(data.items)

    const vehicles = data.items;

    return(
        <React.Fragment>
            <section>
                <h1>Explore Latest</h1>
                <article>
                    {vehicles.map(vehicle => (
                        <div key = {vehicle.car_id}>
                            <VehicleCard
                                key = {vehicle.car_id}
                                id = {vehicle.car_id}
                                brand = {vehicle.brand}
                                model = {vehicle.model}
                                category = {vehicle.category_id}
                            />
                        </div>
                    ))}
                </article>
            </section>
        </React.Fragment>
    );
}