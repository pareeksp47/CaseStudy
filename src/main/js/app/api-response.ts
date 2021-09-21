import { ApiPage } from './api-page';

export interface ApiResponse<T> {
    content: T;
    status: String;
}