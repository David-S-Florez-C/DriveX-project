import { VehicleCard } from "@/components/Cards/VehicleCard";
import { DeleteVehicle } from "../../../components/DeleteVehicle"; 

export default async function Vehicle({params}) {
    
    const {id} = params

    async function getData() {
        const res = await fetch(`https://g4932924a17736e-ca5bxc3sr3p4rtcw.adb.us-chicago-1.oraclecloudapps.com/ords/admin/car/car/${id}`, {cache: 'no-store'});
        return res.json();
    }

    let data = await getData();
    const vehicles = data.items;

    

    return(
        <section>
            <h1>Este es el vehicle {id}</h1>
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
        <DeleteVehicle id = {id}/>
        </section>
    );
}