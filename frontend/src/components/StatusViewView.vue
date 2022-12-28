<template>

    <v-data-table
        :headers="headers"
        :items="statusView"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'StatusViewView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "orderNo", value: "orderNo" },
                { text: "customerId", value: "customerId" },
                { text: "itemNo", value: "itemNo" },
                { text: "qty", value: "qty" },
                { text: "createDate", value: "createDate" },
                { text: "updateDate", value: "updateDate" },
                { text: "orderStatus", value: "orderStatus" },
                { text: "deliveryStatus", value: "deliveryStatus" },
                { text: "customerName", value: "customerName" },
                { text: "transportNo", value: "transportNo" },
                { text: "invoiceNo", value: "invoiceNo" },
                { text: "isShipped", value: "isShipped" },
                { text: "isCoutomsApproved", value: "isCoutomsApproved" },
            ],
            statusView : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/statusViews'))

            temp.data._embedded.statusViews.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.statusView = temp.data._embedded.statusViews;
        },
        methods: {
        }
    }
</script>

