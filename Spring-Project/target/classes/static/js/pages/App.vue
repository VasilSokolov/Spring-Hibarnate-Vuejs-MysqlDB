<template>
    <div>
       <div v-if="!profile">Please log in
           <a href="/login">Login in</a>
       </div>
       <div v-else>
           <div>{{profile.username}}&nbsp;
               <a href="/logout">Logout</a>
           </div>
           <user-list :users="users"/>
       </div>
    </div>
</template>

<script>
    import UserList from 'components/user-list.vue';
    export default {
        components: {
            UserList
        },
        data() {
            return {
                users: frontendData.users,
                profile: frontendData.profile
            }
        }
    }
</script>

<style scoped>

</style>