<template>

    <v-card outlined>
        <v-card-title>
            StatusView # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="OrderNo" v-model="item.orderNo" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="CustomerId" v-model="item.customerId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="ItemNo" v-model="item.itemNo" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Qty" v-model="item.qty" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="CreateDate" v-model="item.createDate" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="UpdateDate" v-model="item.updateDate" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="OrderStatus" v-model="item.orderStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="DeliveryStatus" v-model="item.deliveryStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="CustomerName" v-model="item.customerName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="TransportNo" v-model="item.transportNo" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="InvoiceNo" v-model="item.invoiceNo" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Boolean label="IsShipped" v-model="item.isShipped" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Boolean label="IsCoutomsApproved" v-model="item.isCoutomsApproved" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'StatusViewViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/statusViews/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

