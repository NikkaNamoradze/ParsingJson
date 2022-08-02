package com.example.parsingdataandretrofit.molel

import android.graphics.Color
import com.squareup.moshi.Json

//ვეცადე რომ რა სახის json object მოდიოდა იმის სტრუქტურა
// შემენარჩუნებინა, ისე ყველა data class-ს ცალკე გავიტანდი

data class Product(
    val id: String,
    val projectId: String,
    val equipmentId: String,
    val status: String,
    val requestedBy: String,
    val acceptedBy: Any?,
    val author: String,
    val category: String,
    val locations: Locations,
    val filters: List<Filters>,
    val type: String,
    val organization: String,
    val address: String,
    val startDate: String,
    val endDate: String,
    val description: Any?,
    val prolongDates: List<Any>?,
    val releaseDates: List<Any>?,
    val isDummy: Boolean,
    val hasDriver: Boolean,
    val overwriteDate: Any?,
    val metaInfo: Any?,
    val warehouseId: Any?,
    val rentalDescription: Any?,
    val internalTransportations: InternalTransportations,
    val startDateMilliseconds: Long,
    val endDateMilliseconds: Long,
    val equipment: Equipment,


    ) {
    data class Locations(
        val type: String,
        val coordinates: Coordinates,
    ) {
        data class Coordinates(
            val coordinates: List<Double>
        )
    }

    data class Filters(
        val name: String,
        val value: Value
    ) {
        data class Value(
            val max: Int,
            val min: Int
        )
    }

    data class InternalTransportations(
        val id: String,
        val projectRequestId: String,
        val pickUpDate: String,
        val deliveryDate: String,
        val description: Any?,
        val status: String,
        val startDateOption: Any?,
        val endDateOption: Any?,
        val pickUpLocation: Locations,
        val provider: String,
        val pickUpLocationAddress: String,
        val deliveryLocationAddress: String,
        val pGroup: String,
        val isOrganizedWithoutSam: Any?,
        val templatePGroup: String,
        val pickUpDateMilliseconds: Long,
        val deliveryDateMilliseconds: Long,
        val startDateOptionMilliseconds: Any?,
        val endDateOptionMilliseconds: Any?

    )

    data class Specification(
        val key: String,
        val value: Any,
        //value any იმიტომ მაქვს რომ ზოგ ადგილას სტრინგ ტიპის
        // არის და ზოგან ობიექტის სახით გვხვდება და საჭირო
        // დროს გადაკასტვით ამოვიღებთ იმ მონაცემს რომელიც გვჭირდება

        val weight: Int,
        @Json(name = "additional_specifications")
        val additional_specifications: Any?,
        val structureId: String,
        val organizationId: String,
        val beaconType: Any?,
        val beaconId: String,
        val beaconVendor: String,
        val RFID: String,
        val dailyPrice: Any?,
        val inactive: Any?,
        val tag: Tag,
        val telematicBox: Any?,
        val createdAt: String,
        @Json(name = "special_number")
        val special_number: Any?,
        @Json(name = "last_check")
        val last_check: String,
        @Json(name = "next_check")
        val next_check: String,
        @Json(name = "responsible_person")
        val responsible_person: Any?,
        @Json(name = "test_type")
        val test_type: Any?,
        @Json(name = "unique_equipment_id")
        val unique_equipment_id: String,
        @Json(name = "bgl_number")
        val bgl_number: String,
        @Json(name = "serial_number")
        val serial_number: Any?,
        val inventory: Any?,
        val warehouseId: String,
        val trackingTag: Any?,
        val workingHours: Any?,
        @Json(name = "navaris_criteria")
        val navaris_criteria: Any?,
        @Json(name = "dont_send_to_as400")
        val dont_send_to_as400: Boolean,
        val model: Model,
        val brand: Model.Brand,
        val category: Category,
        val structure: Structure,
        val wareHouse: Any?,
        val equipmentMedia: List<EquipmentMedia>,
        val telematics: List<Telematics>,


        ) {
        data class Tag(
            val date: String,
            val authorName: String,
            val media: List<Any>?,
        )

        data class Model(
            val id: String,
            val name: String,
            val createdAt: String,
            val brand: Brand,
        ) {
            data class Brand(
                val id: String,
                val name: String,
                val createdAt: String
            )
        }

        data class Category(
            val id: String,
            val name: String,
            @Json(name = "name_de")
            val name_de: String,
            val createdAt: String,
            val media: List<Any>?

        )

        data class Structure(
            val id: String,
            val name: String,
            val type: String,
            val color: Color,
        )

        data class EquipmentMedia(
            val id: String,
            val name: String,
            val files: List<Files>,
            val type: String,
            val modelId: String,
            val main: Boolean,
            val modelType: String,
            val createdAt: String
        ) {

            data class Files(
                val size: String,
                val path: String
            )

        }

        data class Telematics(
            val timestamp: Long,
            val eventType: String,
            val projectId: String,
            val equipmentId: String,
            val locationName: String,
            val location: Locations,
            val costCenter: String,
            val lastLatitude: Double,
            val lastLongitude: Double,
            val lastLatLonPrecise: Boolean,
            val lastAddressByLatLon: String,
        )
    }

    data class Equipment(
        val id: String,
        val title: String,
        val invNumber: String,
        val categoryId: String,
        val modelId: String,
        val brandId: String,
        val year: Int,
        val specification: List<Specification>,
        val isMoving: Boolean
    )

}
