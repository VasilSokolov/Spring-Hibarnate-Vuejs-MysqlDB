<template>
    <tbody>
        <tr>
            <td scope="row">({{ user.id }})</td>
            <td>{{ user.firstName }}</td>
            <td>{{ user.lastName }}</td>
            <td>
                <div class="btn-group">
                    <input class="btn btn-primary form-control" aria-pressed="true" type="button" value="Edit" @click="edit"/>
                    <input class="btn btn-danger form-control" aria-pressed="true" type="button" value="Delete" @click="del" />
                </div>
            </td>
        </tr>
    </tbody>
</template>

<script>

    export default {
        name: "user-row",
        props: ['user', 'users', 'editUser', 'deleteUser'],
        methods: {
            edit() {
                this.editUser(this.user);
            },
            del() {
                this.deleteUser(this.user);
            }
        }
    }
</script>

<style scoped>

</style>