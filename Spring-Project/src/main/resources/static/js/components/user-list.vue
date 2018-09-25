<template>
    <div class="container">
    <edit-form :users="users" :editAttr="user"/>
    <table class="table table-bordered">
       <caption>List of users</caption>
        <thead>
            <tr>
                  <th scope="col">#</th>
                  <th scope="col">First Name</th>
                  <th scope="col">Last Name</th>
                  <th scope="col">Operation</th>
                </tr>
          </thead>
        <user-row
                v-for="user in users"
                :key="user.id"
                :user="user"
                :editUser="editUser"
                :deleteUser="deleteUser"
                :users="users" />
    </table>
    </div>
</template>

<script>
    import UserRow from  'components/user-row.vue';
    import EditForm from  'components/edit-form.vue';

    export default {
        name: "user-list",
        components: {
            UserRow,
            EditForm
        },
        props: ['users'],
        data () {
            return {
                user: null
            }
        },
        methods: {
            editUser(user) {
                this.user = user;
            },
            deleteUser(user) {
                this.$resource("/users{/id}").remove({id: user.id}).then(result => {
                        if (result.ok) {
                            this.users.splice(this.users.indexOf(user), 1);
                        }
                    })
            }
        }
    }
</script>

<style scoped>

</style>