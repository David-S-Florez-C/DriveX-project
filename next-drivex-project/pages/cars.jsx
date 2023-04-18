import React, {useState, useEffect} from "react";
import CarCard from "../components/Cards/Vehicles/CarCard";
import AddCar from "../components/CRUD/Cars/AddCar";

export default function Cars() {
    const [carList, setCarList] = useState([]);

    async function fetchData() {
        try{
            const response = await fetch('https://g4932924a17736e-ca5bxc3sr3p4rtcw.adb.us-chicago-1.oraclecloudapps.com/ords/admin/car/car');
            const data = await response.json()
            
            setCarList(data.items)
        } catch(error) {
            console.error(error)
        }
    }

    fetchData();

    if(!carList) {
        return <div>Cargando datos...</div>;
    }

    return(
        <React.Fragment>
            <section>
                <h1>This is the all cars!</h1>
                <article>
                    {carList.map((car) => (
                        <CarCard
                            key = {car.car_id}
                            id = {car.car_id}
                            brand = {car.brand}
                            model = {car.model}
                            category = {car.category_id}
                        />
                    ))}
                </article>
                <AddCar />
            </section>
        </React.Fragment>
    );
};