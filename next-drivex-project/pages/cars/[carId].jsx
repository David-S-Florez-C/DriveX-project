import React, { useState } from "react";
import { useRouter } from "next/router";
import DeleteCar from "../../components/CRUD/Cars/DeleteCar";
import PutCar from "../../components/CRUD/Cars/PutCar";

export default function CarItem() {
    const [car, setCar] = useState([]);
    
    const { query: { carId }, } = useRouter();

    async function fetchData() {
        try {
            const response = await fetch(`https://g4932924a17736e-ca5bxc3sr3p4rtcw.adb.us-chicago-1.oraclecloudapps.com/ords/admin/car/car/${carId}`)
            const data = await response.json();
            setCar(data.items);
        } catch(error) {
            console.log(error);
        }
    }

    fetchData();
    

    return(
        <React.Fragment>
            <section>
                <h1>This is the car: {carId}</h1>
                {car?.map((car) => (
                    <div key = {car.car_id}>
                        <picture>
                            <img src = "" alt = {`Image ${car.car_id}`} />
                        </picture>
                        <div>
                            <h5>{car.brand}</h5>
                            <p>{car.model}</p>
                            <p>{car.category_id}</p>
                        </div>
                    </div>
                ))}
                <DeleteCar carId={carId} />
                <PutCar />
            </section>
        </React.Fragment>
    );
};