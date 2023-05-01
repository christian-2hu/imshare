export interface Response {
    data?: {
        filename: string,
        dataCreated: number
    };
    message: string,
    status: number
}