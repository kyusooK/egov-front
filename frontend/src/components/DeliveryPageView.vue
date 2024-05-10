<template>

    <v-data-table
        :headers="headers"
        :items="deliveryPage"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'DeliveryPageView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "orderId", value: "orderId" },
                { text: "deliveryId", value: "deliveryId" },
                { text: "productId", value: "productId" },
                { text: "productName", value: "productName" },
                { text: "qty", value: "qty" },
                { text: "id", value: "id" },
            ],
            deliveryPage : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/deliveryPages'))

            temp.data._embedded.deliveryPages.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.deliveryPage = temp.data._embedded.deliveryPages;
        },
        methods: {
        }
    }
</script>

